package com.scott.dev.config;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.scott.dev.common.AppConstant;

import freemarker.template.Configuration;

/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import freemarker.template.Version;

/**
 * SpConfiguration
 */
public class AppConfiguration {

    protected static Logger logger = LoggerFactory.getLogger(AppConfiguration.class);

    private static final Properties properties = new Properties();

    private static final Configuration freemarkerConfig;

    private static ServletContext servletContext;

    private static final String system;

    static {
        system = System.getProperty(AppConstant.PROPERTY_OS).toLowerCase();
        if (logger.isInfoEnabled()) {
            logger.info("os.name = " + system);
        }
        File classpath = getClasspathFile("");
        File[] propertyFiles = classpath.listFiles(new FileFilter() {

            @Override
            public boolean accept(File file) {
                return file.getName().endsWith(AppConstant.EXT_PROP);
            }
        });

        for (int i = 0; i < propertyFiles.length; i++) {
            try {
                properties.load(new FileInputStream(propertyFiles[i]));

                if (logger.isInfoEnabled()) {
                    logger.info("load properties file success :" + propertyFiles[i]);
                }
            } catch (IOException e) {
                logger.warn("load properties file failed , skiped :" + propertyFiles[i], e);
            }
        }
        freemarkerConfig = new Configuration(new Version(2, 3, 23));
    }

    public static ClassLoader getClassLoader() {
        return AppConfiguration.class.getClassLoader();
    }

    public static File getClasspathFile(String path) {
        return new File(getClassLoader().getResource(path).getFile());
    }

    public static void init(ServletContext servletContext) {
        AppConfiguration.servletContext = servletContext;
        try {
            freemarkerConfig.setDirectoryForTemplateLoading(
                    new File(getContextPath(AppConstant.DEFAULT_FREEMARKER_DIR)));
            freemarkerConfig.setDefaultEncoding(AppConstant.CHARSET_UTF8);
            if (logger.isInfoEnabled()) {
                logger.info("freemarker template base path set successful!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getContextPath() {
        return getContextPath("");
    }

    public static String getContextPath(String path) {
        String contextFile = servletContext.getRealPath(path);
        if (contextFile == null && !path.startsWith("/")) {
            contextFile = servletContext.getRealPath("/" + path);
        } else if (contextFile == null && path.startsWith("/")) {
            contextFile = servletContext.getRealPath(path.substring(1));
        }
        if (logger.isInfoEnabled()) {
            logger.info("contextFile : " + contextFile);
        }
        return contextFile;
    }

    public static ServletContext getServletContext() {
        return servletContext;
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static Configuration getFreemarkerConfiguration() {
        return freemarkerConfig;
    }

    public static boolean isProductEnv() {
        return system.contains("linux");
    }

    public static String getSiteUrl() {
        return isProductEnv() ? get("context.prd.path") : get("context.path");
    }

    public static String getSiteUrl(String path) {
        return getSiteUrl() + (path.startsWith("/") ? path : ("/" + path));
    }

}

/*
 * Copyright 2018 Jason Robert Weiss
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 *
 */

package com.trailheadsoftware.ping;


import com.trailheadsoftware.ping.api.CorruptedChunkException;
import com.trailheadsoftware.ping.api.IllegalChunkSignatureException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getCanonicalName());

    public static void main(String[] args) {
        PingDecoder decoder = new PingDecoder();

//        File dir = new File("/Users/tacomafour/Desktop/pngsuite");
//
//        // It is also possible to filter the list of returned files.
//        // This example does not return any files that start with `.'.
//        FilenameFilter filter = new FilenameFilter()
//        {
//            public boolean accept(File dir, String name)
//            {
//                return name.toLowerCase().endsWith("png");
//            }
//        };
//
//        File[] files = dir.listFiles(filter);
//        if (logger.isLoggable(Level.FINE))
//            logger.fine("Total PNG files found: " + files.length);
//
//        for (File file : files)
//        {

//        File file = new File("/Users/tacomafour/Desktop/copy.png");
        File file = new File("/Users/tacomafour/Desktop/Elkhorn_Mountain.png");

        if (logger.isLoggable(Level.FINE))
            logger.fine("Processing file " + file.getAbsolutePath());

        InputStream is = null;
        try {

            is = new FileInputStream(file);
            PingGraphic graphic = decoder.decodePing(is);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (UnrecognizedPingSignatureException e) {
            e.printStackTrace();
        } catch (IllegalChunkSignatureException e) {
            e.printStackTrace();
        } catch (CorruptedChunkException e) {
            e.printStackTrace();
        } finally {
            if (null != is)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }
//    }
}
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

import java.io.*;

/**
 *
 */
public class Copier {
    public static void main(String[] args) {
        PingDecoder decoder = new PingDecoder();

        File file = new File(args[0]);
        File outFile = new File(args[1]);

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(file);
            PingGraphic graphic = decoder.decodePing(is);

            //
            // Example of adding IDAT chunks
            //

//            Random rnd = new Random();
//
//            for (int i = 0; i < 5; i++)
//            {
//                IMutableChunk chunk = ChunkFactory.createChunkType(CriticalChunkType.IDAT);
//                byte[] bytes = new byte[graphic.getIdatChunks().get(0).getChunk().getData().length];
//                rnd.nextBytes(bytes);
//                chunk.setData(bytes);
//                IDATChunk idatChunk = new IDATChunk(chunk);
//                graphic.getIdatChunks().add(idatChunk);
//            }

            os = new FileOutputStream(outFile);
            PingEncoder encoder = new PingEncoder();
            encoder.encode(graphic, os);
            os.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (CorruptedChunkException e) {
            e.printStackTrace();
        } catch (UnrecognizedPingSignatureException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != is)
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            if (null != os)
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

}

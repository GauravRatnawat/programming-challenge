package com.anomaly.detector.utility;

import java.text.NumberFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class GeneralUtil {
    private static final Logger LOGGER = LogManager.getLogger(GeneralUtil.class);
    public static void printMemory() {
        Runtime runtime = Runtime.getRuntime();
        final NumberFormat format = NumberFormat.getInstance();
        final long maxMemory = runtime.maxMemory();
        final long allocatedMemory = runtime.totalMemory();
        final long freeMemory = runtime.freeMemory();
        final long mb = ApplicationConstants.Number.ONE_THOUSAND_TWENTY_FOUR * ApplicationConstants.Number.ONE_THOUSAND_TWENTY_FOUR;
        final String mega = " MB";
        LOGGER.info("========================== Memory Info ==========================");
        LOGGER.info("Total Thread:  " + Thread.activeCount());
        LOGGER.info("Free memory: " + format.format(freeMemory / mb) + mega);
        LOGGER.info("Allocated memory: " + format.format(allocatedMemory / mb) + mega);
        LOGGER.info("Max memory: " + format.format(maxMemory / mb) + mega);
        LOGGER.info("Total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / mb) + mega);
        LOGGER.info("=================================================================\n");
    }
}

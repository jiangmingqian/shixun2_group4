package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * �����
 * ����ģ�飺LimeSurvey����ģ�飨��ҳ�趨��ȫ�����ã�
 */

public class Log {
	static Logger logger = LogManager.getLogger(Log.class);

	public static void startTestCase() {
		logger.info("----------------------");

	}

	public static void endTestCase() {
		logger.info("----------------------");

	}

	public static void fatal(String msg) {
		logger.fatal(msg);
	}

	public static void error(String msg) {
		logger.error(msg);
	}

	public static void warn(String msg) {
		logger.warn(msg);
	}

	public static void info(String msg) {
		logger.info(msg);
	}

	public static void debug(String msg) {
		logger.debug(msg);
	}
}

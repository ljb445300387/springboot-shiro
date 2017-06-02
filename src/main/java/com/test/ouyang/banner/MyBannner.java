package com.test.ouyang.banner;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;
import org.springframework.core.env.Environment;

public class MyBannner implements Banner {
	
	private static final String[] BANNER = { "",
		"====================================================",
		"|      change spring boot banner to myBanner        |",
		"|      change spring boot banner to myBanner        |",
		"|      change spring boot banner to myBanner        |",
		"===================================================="
		};

	public void printBanner(Environment paramEnvironment, Class<?> paramClass,
			PrintStream printStream) {
		for (String line : BANNER) {
			printStream.println(line);
		}
		String version = SpringBootVersion.getVersion();
		version = " (v" + version + ")";
		String padding = "";

		while (padding.length() < 42 - (version.length() + " :: Spring Boot :: "
				.length())) {
			padding = padding + " ";
		}

		printStream.println(AnsiOutput.toString(new Object[] { AnsiColor.GREEN,
				" :: Spring Boot :: ", AnsiColor.DEFAULT, padding,
				AnsiStyle.FAINT, version }));

		printStream.println();
	}

}

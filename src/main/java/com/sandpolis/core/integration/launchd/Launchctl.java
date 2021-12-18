package com.sandpolis.core.integration.launchd;

import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sandpolis.core.foundation.S7SFile;
import com.sandpolis.core.foundation.S7SSystem;

public record Launchctl(Path executable) {

	private static final Logger log = LoggerFactory.getLogger(Launchctl.class);

	public static boolean isAvailable() {
		switch (S7SSystem.OS_TYPE) {
		case MACOS:
			return S7SFile.which("launchctl").isPresent();
		default:
			return false;
		}
	}

	public static Launchctl load() {
		if (!isAvailable()) {
			throw new IllegalStateException();
		}

		return new Launchctl(S7SFile.which("launchctl").get().path());
	}
}
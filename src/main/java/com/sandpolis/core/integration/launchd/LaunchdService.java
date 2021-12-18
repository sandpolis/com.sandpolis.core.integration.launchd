package com.sandpolis.core.integration.launchd;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LaunchdService {

	public void write() throws IOException {

		Files.writeString(Paths.get(""), """
				<?xml version="1.0" encoding="UTF-8"?>
				<!DOCTYPE plist PUBLIC "-//Apple//DTD PLIST 1.0//EN" "http://www.apple.com/DTDs/PropertyList-1.0.dtd">
				<plist version="1.0">
				""");
	}

	public void start() {

	}
}

package com.vergilyn.examples.google.jib;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;

import com.google.common.io.CharStreams;

/**
 *
 * @see <a href="https://github.com/GoogleContainerTools/jib/tree/master/examples/helloworld">examples/helloworld</a>
 */
public class HelloworldMain {

	public static void main(String[] args) throws URISyntaxException, IOException {
		try (Reader reader = new InputStreamReader(HelloworldMain.class.getResourceAsStream("/world.txt"),
										StandardCharsets.UTF_8)) {

			String world = CharStreams.toString(reader);
			System.out.println("Hello " + world);
		}
	}
}

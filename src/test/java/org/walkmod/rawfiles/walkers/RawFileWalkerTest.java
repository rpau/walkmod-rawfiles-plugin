/* 
  Copyright (C) 2015 Raquel Pau
 
 Walkmod is free software: you can redistribute it and/or modify
 it under the terms of the GNU Lesser General Public License as published by
 the Free Software Foundation, either version 3 of the License, or
 (at your option) any later version.
 
 Walkmod is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU Lesser General Public License for more details.
 
 You should have received a copy of the GNU Lesser General Public License
 along with Walkmod.  If not, see <http://www.gnu.org/licenses/>.*/
package org.walkmod.rawfiles.walkers;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.walkmod.rawfiles.writers.RawFileWriter;
import org.walkmod.readers.DefaultFileReader;

public class RawFileWalkerTest {

	@Test
	public void simpleTest() throws Exception {

		RawFileWalker walker = new RawFileWalker();
		DefaultFileReader reader = new DefaultFileReader();
		RawFileWriter writer = new RawFileWriter();
		writer.setPlatform("unix");
		reader.setPath("src/test/resources/writeTest");
		writer.setPath("src/test/resources/writeTest");
		File parent = new File("src/test/resources/writeTest/inner");
		File text = new File(parent, "file.txt");
		FileUtils.write(text, "hola\r\n");
		try {
			walker.setResource(reader.read());
			walker.setWriter(writer);
			walker.execute();
			Assert.assertEquals("hola\n", FileUtils.readFileToString(text));
		} finally {
			text.delete();
		}
	}

}

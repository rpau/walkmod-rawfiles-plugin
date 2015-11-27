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
package org.walkmod.rawfiles.writers;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.walkmod.walkers.VisitorContext;

public class RawFileWriterTest {

	@Test
	public void testNoPatflorm() throws Exception {
		RawFileWriter writer = new RawFileWriter();

		File code = new File("src/test/resources/sample.txt");
		FileUtils.write(code, "hello\r\n");
		writer.write(code, new VisitorContext());
		writer.close();
		String finalContent = FileUtils.readFileToString(code);
		Assert.assertEquals("hello\r\n", finalContent);
		code.delete();
	}

	@Test
	public void testFileWriterForUnix() throws Exception {
		RawFileWriter writer = new RawFileWriter();
		writer.setPlatform("unix");
		File code = new File("src/test/resources/sample.txt");
		FileUtils.write(code, "hello\r\n");
		writer.write(code, new VisitorContext());
		writer.close();
		String finalContent = FileUtils.readFileToString(code);
		Assert.assertEquals("hello\n", finalContent);
		code.delete();
	}

	@Test
	public void testFileWriterForWin() throws Exception {
		RawFileWriter writer = new RawFileWriter();
		writer.setPlatform("windows");
		File code = new File("src/test/resources/sample.txt");
		FileUtils.write(code, "hello\n");
		writer.write(code, new VisitorContext());
		writer.close();
		String finalContent = FileUtils.readFileToString(code);
		Assert.assertEquals("hello\r\n", finalContent);
		code.delete();
	}

	@Test
	public void testFileWriterForMac() throws Exception {
		RawFileWriter writer = new RawFileWriter();
		writer.setPlatform("mac");
		File code = new File("src/test/resources/sample.txt");
		FileUtils.write(code, "hello\n");
		writer.write(code, new VisitorContext());
		writer.close();
		String finalContent = FileUtils.readFileToString(code);
		Assert.assertEquals("hello\r", finalContent);
		code.delete();
	}
}

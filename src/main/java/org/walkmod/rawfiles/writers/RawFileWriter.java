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
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.walkmod.walkers.VisitorContext;
import org.walkmod.writers.AbstractFileWriter;

public class RawFileWriter extends AbstractFileWriter {

	@Override
	public File createOutputDirectory(Object o) {
		if (o instanceof File) {
			return (File) o;
		}
		return null;
	}

	@Override
	public String getContent(Object n, VisitorContext vc) {
		if (n instanceof File) {
			File file = (File) n;

			try {
				return FileUtils.readFileToString(file);
			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}
		return null;
	}

}

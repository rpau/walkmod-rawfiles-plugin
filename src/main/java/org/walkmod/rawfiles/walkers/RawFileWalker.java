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

import org.walkmod.walkers.AbstractWalker;
import org.walkmod.walkers.Parser;
import org.walkmod.walkers.VisitorContext;

public class RawFileWalker extends AbstractWalker{

	private boolean reportChanges;
	
	
	@Override
	public int getNumModifications() {
		return 0;
	}

	@Override
	public int getNumAdditions() {
		return 0;
	}

	@Override
	public int getNumDeletions() {
		return 0;
	}

	@Override
	public boolean reportChanges() {
		return reportChanges;
	}

	@Override
	public void setReportChanges(boolean reportChanges) {
		this.reportChanges = reportChanges;
	}

	@Override
	public void setParser(Parser<?> parser) {
	}

	@Override
	public Parser<?> getParser() {
		return null;
	}

	@Override
	protected Object getSourceNode(Object targetNode) {
		return targetNode;
	}
	
	public void visit(File file) throws Exception {
		if (!file.isDirectory()) {
			write(file, new VisitorContext());	
		}
	}
	
	public void walk(Object element) throws Exception {
		visit((File) element);
	}


	@Override
	protected String getLocation(VisitorContext ctx) {
		return null;
	}

}

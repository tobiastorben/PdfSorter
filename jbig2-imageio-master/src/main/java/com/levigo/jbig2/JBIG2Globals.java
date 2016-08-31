/**
 * Copyright (C) 1995-2015 levigo holding gmbh.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.levigo.jbig2;

import java.util.HashMap;
import java.util.Map;

import com.levigo.jbig2.util.log.Logger;
import com.levigo.jbig2.util.log.LoggerFactory;


/**
 * This class stores segments, that aren't associated to a page.
 * 
 * If the data is embedded in another format, for example PDF, this segments might be stored
 * separately in the file.
 * 
 * This segments will be decoded on demand and all results are stored in the document object and can
 * be retrieved from there.
 * 
 * @author <a href="mailto:m.krzikalla@levigo.de">Matthäus Krzikalla</a>
 * 
 */
public class JBIG2Globals {
  private static final Logger log = LoggerFactory.getLogger(JBIG2Globals.class);

  /**
   * This map contains all segments, that are not associated with a page. The key is the segment
   * number.
   */
  private Map<Integer, SegmentHeader> globalSegments = new HashMap<Integer, SegmentHeader>();

  protected SegmentHeader getSegment(int segmentNr) {
    if (globalSegments.size() == 0) {
      if (log.isErrorEnabled()) {
        log.error("No global segment added so far. Use JBIG2ImageReader.setGlobals().");
      }
    }

    return globalSegments.get(segmentNr);
  }

  protected void addSegment(Integer segmentNumber, SegmentHeader segment) {
    globalSegments.put(segmentNumber, segment);
  }

}

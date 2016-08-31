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

package com.levigo.jbig2.util;

/**
 * This enumeration keeps the available logical operator defined in the JBIG2 ISO standard.
 * 
 * @author <a href="mailto:m.krzikalla@levigo.de">Matthäus Krzikalla</a>
 * 
 */
public enum CombinationOperator {
  OR, AND, XOR, XNOR, REPLACE;

  public static CombinationOperator translateOperatorCodeToEnum(short combinationOperatorCode) {
    switch (combinationOperatorCode){
      case 0 :
        return OR;
      case 1 :
        return AND;
      case 2 :
        return XOR;
      case 3 :
        return XNOR;
      default :
        return REPLACE;
    }
  }
}

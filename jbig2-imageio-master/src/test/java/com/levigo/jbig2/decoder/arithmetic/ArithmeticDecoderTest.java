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

package com.levigo.jbig2.decoder.arithmetic;

import java.io.InputStream;
import javax.imageio.stream.ImageInputStream;

import org.junit.*;

import com.levigo.jbig2.io.DefaultInputStreamFactory;

public class ArithmeticDecoderTest {

  long[][] tracedata = { //
      {
          0L, 0x8000L, 0x42638000L, 0x3D9C0000L
      }, {
          0L, 0xAC02L, 0x84C70000L, 0x273A0000L
      }, {
          0L, 0xF002L, 0xA18C7600L, 0x4E758800L
      }, {
          0L, 0xD801L, 0x898B7600L, 0x4E758800L
      }, {
          0L, 0xC000L, 0x718A7600L, 0x4E758800L
      }, {
          0L, 0xA7FFL, 0x59897600L, 0x4E758800L
      }, {
          0L, 0x8FFEL, 0x41887600L, 0x4E758800L
      }, {
          0L, 0xEFFAL, 0x530EEC00L, 0x9CEB1000L
      }, {
          0L, 0xE539L, 0x484DEC00L, 0x9CEB1000L
      }, {
          0L, 0xDA78L, 0x3D8CEC00L, 0x9CEB1000L
      }, {
          0L, 0xCFB7L, 0x32CBEC00L, 0x9CEB1000L
      }, {
          0L, 0xC4F6L, 0x280AEC00L, 0x9CEB1000L
      }, {
          0L, 0xBA35L, 0x1D49EC00L, 0x9CEB1000L
      }, {
          0L, 0xAF74L, 0x1288EC00L, 0x9CEB1000L
      }, {
          1L, 0xA4B3L, 0x07C7EC00L, 0x9CEB1000L
      }, {
          0L, 0xAC10L, 0x7C7EC000L, 0x2F910000L
      }, {
          0L, 0x900FL, 0x607DC000L, 0x2F910000L
      }, {
          0L, 0xE81CL, 0x88F98000L, 0x5F220000L
      }, {
          0L, 0xD21BL, 0x72F88000L, 0x5F220000L
      }, {
          0L, 0xBC1AL, 0x5CF78000L, 0x5F220000L
      }, {
          0L, 0xA619L, 0x46F68000L, 0x5F220000L
      }, {
          0L, 0x9018L, 0x30F58000L, 0x5F220000L
      }, {
          0L, 0xF42EL, 0x35E90000L, 0xBE440000L
      }, {
          0L, 0xE32DL, 0x24E80000L, 0xBE440000L
      }, {
          0L, 0xD22CL, 0x13E70000L, 0xBE440000L
      }, {
          1L, 0xC12BL, 0x02E60000L, 0xBE440000L
      }, {
          0L, 0x8808L, 0x1737E000L, 0x70D01800L
      }, {
          1L, 0xE80EL, 0x066DC000L, 0xE1A03000L
      }, {
          0L, 0x9008L, 0x336E0000L, 0x5C998000L
      }, {
          0L, 0xF40EL, 0x3ADA0000L, 0xB9330000L
      }, {
          0L, 0xE00DL, 0x26D90000L, 0xB9330000L
      }, {
          1L, 0xCC0CL, 0x12D80000L, 0xB9330000L
      }, {
          0L, 0xA008L, 0x96C70800L, 0x0940F000L
      }, {
          0L, 0x8807L, 0x7EC60800L, 0x0940F000L
      }, {
          0L, 0xE00CL, 0xCD8A1000L, 0x1281E000L
      }, {
          0L, 0xCA0BL, 0xB7891000L, 0x1281E000L
      }, {
          0L, 0xB40AL, 0xA1881000L, 0x1281E000L
      }, {
          0L, 0x9E09L, 0x8B871000L, 0x1281E000L
      }, {
          0L, 0x8808L, 0x75861000L, 0x1281E000L
      }, {
          0L, 0xE40EL, 0xBF0A2000L, 0x2503C000L
      }, {
          0L, 0xD00DL, 0xAB092000L, 0x2503C000L
      }, {
          0L, 0xBC0CL, 0x97082000L, 0x2503C000L
      }, {
          0L, 0xA80BL, 0x83072000L, 0x2503C000L
      }, {
          0L, 0x940AL, 0x6F062000L, 0x2503C000L
      }, {
          0L, 0x8009L, 0x5B052000L, 0x2503C000L
      }, {
          0L, 0xD810L, 0x8E084000L, 0x4A078000L
      }, {
          0L, 0xC60FL, 0x7C074000L, 0x4A078000L
      }, {
          0L, 0xB40EL, 0x6A064000L, 0x4A078000L
      }, {
          0L, 0xA20DL, 0x58054000L, 0x4A078000L
      }, {
          0L, 0x900CL, 0x46044000L, 0x4A078000L
      }, {
          0L, 0xFC16L, 0x68068000L, 0x940F0000L
      }, {
          0L, 0xEB15L, 0x57058000L, 0x940F0000L
      }, {
          0L, 0xDA14L, 0x46048000L, 0x940F0000L
      }, {
          0L, 0xC913L, 0x35038000L, 0x940F0000L
      }, {
          0L, 0xB812L, 0x24028000L, 0x940F0000L
      }, {
          0L, 0xA711L, 0x13018000L, 0x940F0000L
      }, {
          1L, 0x9610L, 0x02008000L, 0x940F0000L
      }, {
          1L, 0x8808L, 0x10068400L, 0x78017800L
      }, {
          0L, 0xA008L, 0x80342000L, 0x1FD3C000L
      }, {
          0L, 0x8807L, 0x68332000L, 0x1FD3C000L
      }, {
          0L, 0xE00CL, 0xA0644000L, 0x3FA78000L
      }, {
          0L, 0xCA0BL, 0x8A634000L, 0x3FA78000L
      }, {
          0L, 0xB40AL, 0x74624000L, 0x3FA78000L
      }, {
          0L, 0x9E09L, 0x5E614000L, 0x3FA78000L
      }, {
          0L, 0x8808L, 0x48604000L, 0x3FA78000L
      }, {
          0L, 0xE40EL, 0x64BE8000L, 0x7F4F0000L
      }, {
          0L, 0xD00DL, 0x50BD8000L, 0x7F4F0000L
      }, {
          0L, 0xBC0CL, 0x3CBC8000L, 0x7F4F0000L
      }, {
          0L, 0xA80BL, 0x28BB8000L, 0x7F4F0000L
      }, {
          0L, 0x940AL, 0x14BA8000L, 0x7F4F0000L
      }, {
          1L, 0x8009L, 0x00B98000L, 0x7F4F0000L
      }, {
          1L, 0xA008L, 0x05CD0C00L, 0x9A3AF000L
      }, {
          0L, 0xC008L, 0x2E686000L, 0x919F8000L
      }, {
          1L, 0x9E07L, 0x0C676000L, 0x919F8000L
      }, {
          0L, 0x8804L, 0x319D8000L, 0x56660000L
      }, {
          1L, 0xC006L, 0x13390000L, 0xACCC0000L
      }, {
          0L, 0x9004L, 0x4CE41000L, 0x431FEC00L
      }, {
          0L, 0xC006L, 0x39C62000L, 0x863FD800L
      }, {
          1L, 0x9805L, 0x11C52000L, 0x863FD800L
      }, {
          0L, 0xA004L, 0x47148000L, 0x58EF6000L
      }, {
          1L, 0xD806L, 0x26270000L, 0xB1DEC000L
      }, {
          0L, 0xC004L, 0x989C0000L, 0x27670000L
      }, {
          0L, 0x8C03L, 0x649B0000L, 0x27670000L
      }, {
          0L, 0xB004L, 0x61340400L, 0x4ECFFA00L
      }, {
          0L, 0x8003L, 0x31330400L, 0x4ECFFA00L
      }, {
          1L, 0xA004L, 0x02640800L, 0x9D9FF400L
      }, {
          1L, 0xA004L, 0x09902000L, 0x9673D000L
      }, {
          1L, 0xD004L, 0x26408000L, 0xA9C34000L
      }, {
          0L, 0xE004L, 0x99020000L, 0x47010000L
      }, {
          0L, 0x9803L, 0x51010000L, 0x47010000L
      }, {
          1L, 0xA004L, 0x12004000L, 0x8E03BE00L
      }, {
          0L, 0xE004L, 0x48010000L, 0x9802F800L
      }, {
          1L, 0x9803L, 0x00000000L, 0x9802F800L
      }, {
          0L, 0x9002L, 0x00000000L, 0x9001F000L
      }, {
          1L, 0xA202L, 0x00000000L, 0xA201E000L
      }, {
          0L, 0x9002L, 0x00000000L, 0x9001C000L
      }, {
          1L, 0xA202L, 0x00000000L, 0xA2018000L
      }, {
          0L, 0x9002L, 0x00000000L, 0x90010000L
      }, {
          1L, 0xA202L, 0x00000000L, 0xA201FE00L
      }, {
          0L, 0x9002L, 0x00000000L, 0x9001FC00L
      }, {
          1L, 0xA202L, 0x00000000L, 0xA201F800L
      }, {
          0L, 0x9002L, 0x00000000L, 0x9001F000L
      }, {
          1L, 0xA202L, 0x00000000L, 0xA201E000L
      }, {
          0L, 0x9002L, 0x00000000L, 0x9001C000L
      }, {
          1L, 0xA202L, 0x00000000L, 0xA2018000L
      }, {
          0L, 0x9002L, 0x00000000L, 0x90010000L
      }, {
          1L, 0xA202L, 0x00000000L, 0xA201FE00L
      }, {
          0L, 0x9002L, 0x00000000L, 0x9001FC00L
      }, {
          1L, 0xA202L, 0x00000000L, 0xA201F800L
      }, {
          0L, 0x9002L, 0x00000000L, 0x9001F000L
      }, {
          1L, 0xA202L, 0x00000000L, 0xA201E000L
      }, {
          0L, 0x9002L, 0x00000000L, 0x9001C000L
      }, {
          1L, 0xA202L, 0x00000000L, 0xA2018000L
      }, {
          0L, 0x9002L, 0x00000000L, 0x90010000L
      }, {
          1L, 0xA202L, 0x00008200L, 0xA2017C00L
      }, {
          0L, 0x9002L, 0x00010400L, 0x9000F800L
      }, {
          1L, 0xA202L, 0x00020800L, 0xA1FFF000L
      }, {
          0L, 0x9002L, 0x00041000L, 0x8FFDE000L
      }, {
          1L, 0xA202L, 0x00082000L, 0xA1F9C000L
      }, {
          0L, 0x9002L, 0x00104000L, 0x8FF18000L
      }, {
          1L, 0xA202L, 0x00208000L, 0xA1E10000L
      }, {
          0L, 0x9002L, 0x00410000L, 0x8FC00000L
      }, {
          1L, 0xA202L, 0x00821A00L, 0xA17FE400L
      }, {
          0L, 0x9002L, 0x01043400L, 0x8EFDC800L
      }, {
          1L, 0xA202L, 0x02086800L, 0x9FF99000L
      }, {
          0L, 0x9002L, 0x0410D000L, 0x8BF12000L
      }, {
          1L, 0xA202L, 0x0821A000L, 0x99E04000L
      }, {
          0L, 0x9002L, 0x10434000L, 0x7FBE8000L
      }, {
          1L, 0xA202L, 0x20868000L, 0x817B0000L
      }, {
          0L, 0x9002L, 0x410D0000L, 0x4EF40000L
      }, {
          0L, 0xA202L, 0x821B7600L, 0x1FE68800L
      }, {
          0L, 0xB402L, 0x7434EC00L, 0x3FCD1000L
      }, {
          0L, 0xF802L, 0x7867D800L, 0x7F9A2000L
      }, {
          0L, 0xC401L, 0x4466D800L, 0x7F9A2000L
      }, {
          1L, 0x9000L, 0x1065D800L, 0x7F9A2000L
      }, {
          0L, 0xD004L, 0x41976000L, 0x8E6C8000L
      }, {
          1L, 0x9803L, 0x09966000L, 0x8E6C8000L
      }, {
          1L, 0xE004L, 0x26598000L, 0xB9AA0000L
      }, {
          0L, 0x9002L, 0x4CB30000L, 0x434E0000L
      }, {
          0L, 0xA202L, 0x99670C00L, 0x089AF200L
      }, {
          0L, 0xB402L, 0xA2CC1800L, 0x1135E400L
      }, {
          0L, 0xF802L, 0xD5963000L, 0x226BC800L
      }, {
          0L, 0xC401L, 0xA1953000L, 0x226BC800L
      }, {
          0L, 0x9000L, 0x6D943000L, 0x226BC800L
      }, {
          0L, 0xB7FEL, 0x73266000L, 0x44D79000L
      }, {
          0L, 0x87FDL, 0x43256000L, 0x44D79000L
      }, {
          1L, 0xAFF8L, 0x2648C000L, 0x89AF2000L
      }, {
          0L, 0xA004L, 0x99230000L, 0x06E08000L
      }, {
          0L, 0xD806L, 0xCA440000L, 0x0DC10000L
      }, {
          0L, 0xA805L, 0x9A430000L, 0x0DC10000L
      }, {
          0L, 0xF008L, 0xD485E800L, 0x1B821600L
      }, {
          0L, 0xC807L, 0xAC84E800L, 0x1B821600L
      }, {
          0L, 0xA006L, 0x8483E800L, 0x1B821600L
      }, {
          0L, 0xF00AL, 0xB905D000L, 0x37042C00L
      }, {
          0L, 0xCC09L, 0x9504D000L, 0x37042C00L
      }, {
          0L, 0xA808L, 0x7103D000L, 0x37042C00L
      }, {
          0L, 0x8407L, 0x4D02D000L, 0x37042C00L
      }, {
          0L, 0xC00CL, 0x5203A000L, 0x6E085800L
      }, {
          0L, 0x9E0BL, 0x3002A000L, 0x6E085800L
      }, {
          0L, 0xF814L, 0x1C034000L, 0xDC10B000L
      }, {
          1L, 0xDC13L, 0x00024000L, 0xDC10B000L
      }, {
          1L, 0xE008L, 0x00120000L, 0xDFF58000L
      }, {
          1L, 0x9004L, 0x00486200L, 0x8FBB9C00L
      }, {
          1L, 0xC004L, 0x01218800L, 0xBEE27000L
      }, {
          1L, 0xD004L, 0x04862000L, 0xCB7DC000L
      }, {
          1L, 0xE004L, 0x12188000L, 0xCDEB0000L
      }, {
          0L, 0x9002L, 0x24310000L, 0x6BD00000L
      }, {
          0L, 0xA202L, 0x4862FE00L, 0x599F0000L
      }, {
          1L, 0xB402L, 0x00C3FC00L, 0xB33E0000L
      }, {
          1L, 0xE004L, 0x030FF000L, 0xDCF40000L
      }, {
          0L, 0x9002L, 0x061FE000L, 0x89E20000L
      }, {
          1L, 0xA202L, 0x0C3FC000L, 0x95C20000L
      }, {
          0L, 0x9002L, 0x187F8000L, 0x77820000L
      }, {
          1L, 0xA202L, 0x30FF0000L, 0x71020000L
      }, {
          1L, 0x9002L, 0x61FFFE00L, 0x2E020000L
      }, {
          1L, 0xFC04L, 0x43FBF800L, 0xB8080000L
      }, {
          1L, 0xA802L, 0x87F7F000L, 0x200A0000L
      }, {
          0L, 0xA402L, 0x63EDE000L, 0x40140000L
      }, {
          0L, 0x9C02L, 0x1BD9C000L, 0x80280000L
      }, {
          1L, 0xAC02L, 0x37B38000L, 0x744E0000L
      }, {
          1L, 0xA802L, 0x6F670000L, 0x389A0000L
      }, {
          1L, 0xA402L, 0x32CE2000L, 0x7133DC00L
      }, {
          1L, 0xAC02L, 0x659C4000L, 0x4665B800L
      }, {
          0L, 0xB002L, 0x23368000L, 0x8CCB7000L
      }, {
          1L, 0xA202L, 0x466D0000L, 0x5B94E000L
      }, {
          1L, 0xA802L, 0x8CDA0000L, 0x1B27C000L
      }, {
          1L, 0xAE02L, 0x77B20000L, 0x364F8000L
      }, {
          1L, 0xCC02L, 0x5F620000L, 0x6C9F0000L
      }, {
          0L, 0x9401L, 0x27610000L, 0x6C9F0000L
      }, {
          1L, 0xE004L, 0x9D87FC00L, 0x427C0000L
      }, {
          1L, 0x9803L, 0x5586FC00L, 0x427C0000L
      }, {
          0L, 0xA004L, 0x1B0BF800L, 0x84F80000L
      }, {
          1L, 0xE004L, 0x6C2FE000L, 0x73D40000L
      }, {
          0L, 0x9803L, 0x242EE000L, 0x73D40000L
      }, {
          1L, 0x9002L, 0x485DC000L, 0x47A40000L
      }, {
          1L, 0xA202L, 0x90BB8000L, 0x11460000L
      }, {
          1L, 0xB402L, 0x91750000L, 0x228C0000L
      }, {
          1L, 0xF802L, 0xB2E8DC00L, 0x45192000L
      }, {
          1L, 0xC401L, 0x7EE7DC00L, 0x45192000L
      }, {
          1L, 0x9000L, 0x4AE6DC00L, 0x45192000L
      }, {
          0L, 0xB7FEL, 0x2DCBB800L, 0x8A324000L
      }, {
          1L, 0xC004L, 0xB72EE000L, 0x08D50000L
      }, {
          1L, 0x8C03L, 0x832DE000L, 0x08D50000L
      }, {
          1L, 0xB004L, 0x9E59C000L, 0x11AA0000L
      }, {
          1L, 0x8003L, 0x6E58C000L, 0x11AA0000L
      }, {
          1L, 0xA004L, 0x7CAF8000L, 0x23540000L
      }, {
          1L, 0xF006L, 0xA95D0000L, 0x46A80000L
      }, {
          1L, 0xCC05L, 0x855C0000L, 0x46A80000L
      }, {
          1L, 0xA804L, 0x615B0000L, 0x46A80000L
      }, {
          1L, 0x8403L, 0x3D5A0000L, 0x46A80000L
      }, {
          1L, 0xC004L, 0x32B28E00L, 0x8D517000L
      }, {
          0L, 0x9E03L, 0x10B18E00L, 0x8D517000L
      }, {
          1L, 0x8804L, 0x42C63800L, 0x453DC000L
      }, {
          1L, 0xC006L, 0x358A7000L, 0x8A7B8000L
      }, {
          0L, 0x9C05L, 0x11897000L, 0x8A7B8000L
      }, {
          1L, 0x9004L, 0x4625C000L, 0x49DE0000L
      }, {
          1L, 0xC006L, 0x2C498000L, 0x93BC0000L
      }, {
          0L, 0x9805L, 0x04488000L, 0x93BC0000L
      }, {
          0L, 0xA004L, 0x11223400L, 0x8EE1CA00L
      }, {
          1L, 0xD004L, 0x4488D000L, 0x8B7B2800L
      }, {
          0L, 0x9803L, 0x0C87D000L, 0x8B7B2800L
      }, {
          0L, 0xE004L, 0x321F4000L, 0xADE4A000L
      }, {
          0L, 0x9002L, 0x643E8000L, 0x2BC34000L
      }, {
          0L, 0xFC04L, 0x4CF60000L, 0xAF0D0000L
      }, {
          0L, 0xA802L, 0x99EDB600L, 0x0E144800L
      }, {
          1L, 0xA402L, 0x87D96C00L, 0x1C289000L
      }, {
          0L, 0x9C02L, 0x63B0D800L, 0x38512000L
      }, {
          0L, 0x8C02L, 0x1B5FB000L, 0x70A24000L
      }, {
          1L, 0xAC02L, 0x36BF6000L, 0x75428000L
      }, {
          1L, 0xA802L, 0x6D7EC000L, 0x3A830000L
      }, {
          1L, 0xA402L, 0x2EFB8000L, 0x75060000L
      }, {
          1L, 0xAC02L, 0x5DF70000L, 0x4E0A0000L
      }, {
          0L, 0xB002L, 0x13ECD400L, 0x9C152A00L
      }, {
          1L, 0xA202L, 0x27D9A800L, 0x7A285400L
      }, {
          0L, 0xA802L, 0x4FB35000L, 0x584EA800L
      }, {
          0L, 0xA202L, 0x9F66A000L, 0x029B5000L
      }, {
          0L, 0x9C02L, 0x96CB4000L, 0x0536A000L
      }, {
          1L, 0x8C02L, 0x81948000L, 0x0A6D4000L
      }, {
          1L, 0xD804L, 0xAE4E0000L, 0x29B50000L
      }, {
          0L, 0x8203L, 0x584D0000L, 0x29B50000L
      }, {
          1L, 0xB008L, 0x09337C00L, 0xA6D48000L
      }, {
          0L, 0xAC02L, 0x1266F800L, 0x999B0000L
      }, {
          1L, 0xAC02L, 0x24CDF000L, 0x87340000L
      }, {
          0L, 0xAC02L, 0x499BE000L, 0x62660000L
      }, {
          0L, 0xAC02L, 0x9337C000L, 0x18CA0000L
      }, {
          0L, 0xAC02L, 0x7A6D8000L, 0x31940000L
      }, {
          1L, 0xB002L, 0x4CD90000L, 0x63280000L
      }, {
          1L, 0xA202L, 0x99B3FE00L, 0x084E0000L
      }, {
          1L, 0x9C02L, 0x8B65FC00L, 0x109C0000L
      }, {
          0L, 0x8C02L, 0x6AC9F800L, 0x21380000L
      }, {
          1L, 0xD804L, 0x5323E000L, 0x84E00000L
      }, {
          1L, 0xAC02L, 0xA647C000L, 0x05BA0000L
      }, {
          1L, 0xAC02L, 0xA08D8000L, 0x0B740000L
      }, {
          1L, 0xB002L, 0x99190000L, 0x16E80000L
      }, {
          1L, 0xBE02L, 0x9031FE00L, 0x2DD00000L
      }, {
          1L, 0xEC02L, 0x9061FC00L, 0x5BA00000L
      },
  };

  @Test
  public void decodeTest() throws Throwable {
    InputStream is = getClass().getResourceAsStream("/images/arith/encoded testsequence");
    DefaultInputStreamFactory factory = new DefaultInputStreamFactory();
    ImageInputStream iis = factory.getInputStream(is);

    ArithmeticDecoder decoder = new ArithmeticDecoder(iis);

    CX cx = new CX(1, 0);
    for (int i = 0; i < 257; i++) {
      decoder.decode(cx);
    }

  }

  @Test
  public void decodeTestWithTracadataComparison() throws Throwable {
    InputStream is = getClass().getResourceAsStream("/images/arith/encoded testsequence");
    DefaultInputStreamFactory factory = new DefaultInputStreamFactory();
    ImageInputStream iis = factory.getInputStream(is);

    ArithmeticDecoder decoder = new ArithmeticDecoder(iis);
    CX cx = new CX(1, 0);

    for (int i = 0; i < 255; i++) {
      Assert.assertEquals(tracedata[i][0], decoder.decode(cx));
      Assert.assertEquals(tracedata[i + 1][1], (long) decoder.getA());
      Assert.assertEquals(tracedata[i + 1][2], decoder.getC());

    }
  }
}

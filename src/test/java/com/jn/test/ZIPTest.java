package com.jn.test;


public class ZIPTest {

//	@Test
//	public void test_01() {
//		try {
//			FileOutputStream fou = new FileOutputStream(
//					"d:\\Temp\\a\\a\\b\\c.zip");
//			ArchiveOutputStream archOuts = new ArchiveStreamFactory()
//					.createArchiveOutputStream(ArchiveStreamFactory.ZIP, fou);
//			if (archOuts instanceof ZipArchiveOutputStream) {
//				ZipArchiveOutputStream zipOut = (ZipArchiveOutputStream) archOuts;
//				
//				
//				String file2="D:\\Temp\\a\\c";
//				ZipArchiveEntry zipEntry2 = new ZipArchiveEntry(new File(file2),
//						SystemUtil.getFileSimpleName(file2));
//				
//				zipOut.putArchiveEntry(zipEntry2);
//				String file = "D:\\Temp\\a\\c\\password_密码.xls";
//				ZipArchiveEntry zipEntry1 = new ZipArchiveEntry(new File(file),"c\\"+
//						SystemUtil.getFileSimpleName(file));
//				zipOut.putArchiveEntry(zipEntry1);
//				
//				
//				zipOut.write(FileUtils.readBytes4file(file));
//
//				zipOut.closeArchiveEntry();
//				zipOut.flush();
//				zipOut.finish();
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (ArchiveException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void test_02() {
//		try {
//
//			// String file01 = "D:\\Temp\\a\\password_密码.xls";
//			// String file02 = "D:\\Temp\\a\\ccc.jar";
//			File file01 = new File("D:\\Temp\\a\\password_密码.xls");
//			File file02 = new File("D:\\Temp\\a\\ccc.jar");
//			List<File> filePaths = new ArrayList<File>();
//			filePaths.add(file01);
//			filePaths.add(file02);
//			CompressZipUtil.compressZip("d:\\Temp\\a\\a\\b\\c.zip", filePaths);
//
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (ArchiveException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
//
//	@Test
//	public void test03() throws ArchiveException, IOException{
//		String zipPath="D:\\Temp\\a\\a\\b\\c.zip";
//		CompressZipUtil.decompress(zipPath,"D:\\Temp\\a\\c");
//	}

}

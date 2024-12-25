package utils;

public class ChangeDesktopBackground {
	private String newWallpaperPath;
	
	public ChangeDesktopBackground(String newWalpaperPath) {
		System.out.println("Path: " + newWalpaperPath);
		this.newWallpaperPath = newWalpaperPath;
	}
	
	public void changeDesktop() {
		try {
//			 Sử dụng lệnh của hệ điều hành để thay đổi hình nền
			String cmd = "reg add \"HKEY_CURRENT_USER\\Control Panel\\Desktop\" /v Wallpaper /t REG_SZ /d \"" + newWallpaperPath + "\" /f";
			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
			if(process.exitValue() == 0) {
//				Áp dụng hình nền mới
				Runtime.getRuntime().exec("rundll32.exe user32.dll, UpdatePerUserSystemParameters");
//				Thông báo thành công
				System.out.println("Change desktopscreen success!!!");
			} else {
//				Thông báo lỗi nếu có
				System.out.println("Change desktopscreen failed !!!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

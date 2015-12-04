package global.value.service;

public class GlobalValueService {
	/** 輸出字串 IMG **/
	private final String IMG_TAG_CHECK = "<img src='../../images/check.gif'>&nbsp;";
	private final String IMG_TAG_UNCHECK = "<img src='../../images/uncheck.gif'>&nbsp;";

	public String getIMG_TAG_CHECK() {
		return IMG_TAG_CHECK;
	}

	public String getIMG_TAG_UNCHECK() {
		return IMG_TAG_UNCHECK;
	}

}

package kr.or.ddit.autumn.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="apfNo")
public class AppFormVO {
	@NotNull
	private Integer apfNo;
	@NotBlank
	private String comCode;
	@NotBlank
	private String apfNm;
	@NotBlank
	private String apfCat;
	private String apfFayn;
}

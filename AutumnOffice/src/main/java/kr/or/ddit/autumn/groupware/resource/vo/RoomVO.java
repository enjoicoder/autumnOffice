package kr.or.ddit.autumn.groupware.resource.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="meetNo")
public class RoomVO {
	@NotNull
	private Integer meetNo;
	@NotBlank
	private String comCode;
	@NotBlank
	private String meetNm;
	@NotBlank
	private String meetInd;
	@NotBlank
	private String meetUpd;
	
	private Integer meetCount;
}

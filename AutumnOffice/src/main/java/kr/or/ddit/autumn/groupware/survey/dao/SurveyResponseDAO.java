package kr.or.ddit.autumn.groupware.survey.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.or.ddit.autumn.vo.SurveyArticleVO;
import kr.or.ddit.autumn.vo.SurveyInvestigationVO;
import kr.or.ddit.autumn.vo.SurveyQuestionVO;
import kr.or.ddit.autumn.vo.SurveyResponseVO;
import kr.or.ddit.autumn.vo.SurveyVO;

@Mapper
public interface SurveyResponseDAO {
	public int insertSurveyResponse(SurveyResponseVO surveyResponse);
	public List<SurveyVO> selectSurveyList(SurveyVO survey);
	public List<SurveyQuestionVO> selectSurveyQuestionList(SurveyQuestionVO surveyQuestion);
	public List<SurveyArticleVO> selectSurveyArticleList(SurveyArticleVO surveyArticle);
	public int idCheck(SurveyResponseVO surveyResponse);
	public List<SurveyResponseVO> selectSurveyResponse(int surinvNo);
}

package kr.or.ddit.autumn.groupware.survey.service;

import java.util.List;

import kr.or.ddit.autumn.commons.enumpkg.ServiceResult;
import kr.or.ddit.autumn.vo.SurveyArticleVO;
import kr.or.ddit.autumn.vo.SurveyInvestigationVO;
import kr.or.ddit.autumn.vo.SurveyQuestionVO;
import kr.or.ddit.autumn.vo.SurveyResponseVO;
import kr.or.ddit.autumn.vo.SurveyVO;

public interface SurveyResponseService {
	public ServiceResult createSurveyResponse(SurveyResponseVO surveyResponse);
	public List<SurveyVO> retrieveSurveyList(SurveyVO survey);
	public List<SurveyQuestionVO> retrieveSurveyQuestionList(SurveyQuestionVO surveyQuestion);
	public List<SurveyArticleVO> retrieveSurveyArticleList(SurveyArticleVO surveyArticle);
	public int idCheck(SurveyResponseVO surveyResponse);
	public List<SurveyResponseVO> selectSurveyResponseList(int surinvNo);
}

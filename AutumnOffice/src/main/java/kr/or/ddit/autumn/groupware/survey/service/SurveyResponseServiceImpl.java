package kr.or.ddit.autumn.groupware.survey.service;

import java.util.List;

import org.springframework.stereotype.Service;

import kr.or.ddit.autumn.commons.enumpkg.ServiceResult;
import kr.or.ddit.autumn.groupware.survey.dao.SurveyResponseDAO;
import kr.or.ddit.autumn.vo.SurveyArticleVO;
import kr.or.ddit.autumn.vo.SurveyQuestionVO;
import kr.or.ddit.autumn.vo.SurveyResponseVO;
import kr.or.ddit.autumn.vo.SurveyVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SurveyResponseServiceImpl implements SurveyResponseService {
	
	private final SurveyResponseDAO resDAO;
	

	@Override
	public List<SurveyVO> retrieveSurveyList(SurveyVO survey) {
		return resDAO.selectSurveyList(survey);
	}

	@Override
	public List<SurveyQuestionVO> retrieveSurveyQuestionList(SurveyQuestionVO surveyQuestion) {
		return resDAO.selectSurveyQuestionList(surveyQuestion);
	}

	@Override
	public List<SurveyArticleVO> retrieveSurveyArticleList(SurveyArticleVO surveyArticle) {
		return resDAO.selectSurveyArticleList(surveyArticle);
	}

	@Override
	public ServiceResult createSurveyResponse(SurveyResponseVO surveyResponse) {
		int rowcnt = resDAO.insertSurveyResponse(surveyResponse);
		return rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
	}

	@Override
	public int idCheck(SurveyResponseVO surveyResponse) {
		int result = resDAO.idCheck(surveyResponse);
		return result;
	}

	@Override
	public List<SurveyResponseVO> selectSurveyResponseList(int surinvNo) {
		return resDAO.selectSurveyResponse(surinvNo);
	}




}

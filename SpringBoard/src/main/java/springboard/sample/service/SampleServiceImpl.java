package springboard.sample.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import springboard.sample.dao.SampleDao;

@Service("sampleService")
public class SampleServiceImpl implements SampleService {
	Logger log = Logger.getLogger(SampleServiceImpl.class);

	@Resource(name = "sampleDao")
	private SampleDao sampleDao;

	@Override
	public List<Map<String, Object>> selectBoard(Map<String, Object> commonMap) throws Exception {
		return sampleDao.selectBoardList(commonMap);
	}

	@Override
	public synchronized void insertBoard(Map<String, Object> commonMap) throws Exception {

		String maxSeq = sampleDao.selectMaxBoardSeq();
		commonMap.put("BOARD_SEQ", maxSeq);
		commonMap.put("PARENT_SEQ", null);

		sampleDao.insertBoard(commonMap);
	}

	@Override
	public Map<String, Object> selectUserConfirm(Map<String, Object> commonMap) throws Exception {
		Map<String, Object> resultMap = null;
		
		resultMap = sampleDao.selectUserConfirm(commonMap);
				
		return null;
	}

	
}

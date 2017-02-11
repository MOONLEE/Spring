package springboard.sample.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import springboard.common.dao.AbstractDao;

@Repository("sampleDao")
public class SampleDao extends AbstractDao{

	public List<Map<String, Object>> selectBoardList(Map<String, Object> commonMap) throws Exception {
		
		return (List<Map<String, Object>>)this.selectList("sample.selectBoardList");
	}

	public String selectMaxBoardSeq() throws Exception {
		Map<String, Object> result = (Map<String, Object>) this.selectOne("sample.selectMaxBoardSeq");
		String maxSeq = String.valueOf(result.get("MAX_SEQ"));
		
		return maxSeq;
	}

	public void insertBoard(Map<String, Object> commonMap) throws Exception {
		this.insert("sample.insertBoard", commonMap);
	}

	public Map<String, Object> selectUserConfirm(Map<String, Object> commonMap) throws Exception {
		
		return (Map<String, Object>) this.selectOne("sample.selectUserConfirm", commonMap);
	}
	
}

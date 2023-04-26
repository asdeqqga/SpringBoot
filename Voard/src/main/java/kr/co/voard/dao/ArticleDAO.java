package kr.co.voard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.co.voard.vo.ArticleVO;
import kr.co.voard.vo.FileVO;

@Mapper
@Repository
public interface ArticleDAO {
	public int insertArticle(ArticleVO vo);
	public int insertFile(FileVO vo);
	public FileVO selectFile(int fno);
	public int selectCountTotal();
	public ArticleVO selectArticle(int no);
	public List<ArticleVO> selectArticles(@Param("start") int start, @Param("cate") String cate);
	public int updateArticle(ArticleVO vo);
	public int updateDownload(int fno);
	public int deleteArticle(int no);
}
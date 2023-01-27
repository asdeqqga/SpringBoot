package kr.co.farmstory.service;

import kr.co.farmstory.dao.ArticleDAO;
import kr.co.farmstory.repository.ArticleRepo;
import kr.co.farmstory.vo.ArticleVO;
import kr.co.farmstory.vo.FileVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ArticleService {

    @Autowired
    private ArticleDAO dao;

    @Autowired
    private ArticleRepo repo;

    @Transactional
    public int insertArticle(ArticleVO vo){
        // 글 등록
        int result = dao.insertArticle(vo);
        // 파일 업로드
        //FileVO fvo = FileUpload
        // 파일 등록
        //if(fvo != null) {
        //    dao.insertFile(fvo);
        //}

        return result;
    }

    public FileVO selectFile(int fno) {
        FileVO vo = dao.selectFile(fno);
        dao.updateDownload(fno);
        return vo;
    }

    public ArticleVO selectArticle(int no) {
        return dao.selectArticle(no);
    }

    public List<ArticleVO> selectArticles(String cate) {
        return dao.selectArticles(cate);
    }

    public int updateArticle(ArticleVO vo) {
        return dao. updateArticle(vo);
    }

    public int deleteArticle(int no){
        return dao.deleteArticle(no);
    }

}

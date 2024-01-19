package com.project.coc.board.service.Impl;

import com.project.coc.board.mapper.BoardMapper;
import com.project.coc.board.model.Board;
import com.project.coc.board.model.BoardRequest;
import com.project.coc.board.model.UpdateBoardRequest;
import com.project.coc.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Service
public class BoardServiceImpl implements BoardService {

    private final BoardMapper mapper;

    @Transactional(readOnly = true)
    @Override
    public List<Board> selectBoardList(BoardRequest request) {
        try {
            return mapper.selectBoardList(request);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Board selectBoard(String seq) {
        try {
            return mapper.selectBoard(seq);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    @Override
    public void regiBoard(BoardRequest request) {
        try {
            mapper.regiBoard(request);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    @Override
    public void updateBoard(String seq, UpdateBoardRequest request) {
        try {
            Board checkBoard = mapper.selectBoard(seq);
            if(checkBoard == null){
                System.out.println("존재하지 않는 게시물 입니다.");
            }
            mapper.updateBoard(seq);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Transactional
    @Override
    public void deleteBoard(String seq) {
        try{
            mapper.deleteBoard(seq);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
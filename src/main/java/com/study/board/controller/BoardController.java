package com.study.board.controller;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller // 골뱅이를 어노테이션이라고함 / 스프링이 재실행을 할때 여기가 컨트롤러라고 인식을함
public class BoardController {

    @Autowired
    private BoardService boardService;

   @GetMapping("/board/write") // localhost:8080/board/write / 어떤 url로 접근할 건지 지정해주는 오노테이션
    public String boardWriteForm() {

        return "boardwrite"; // 소문자로 작성했기 때문에
    }

    @PostMapping("/board/writepro")
    public String boardWritePro(Board board) {

        boardService.write(board);

       return "";
    }

    @GetMapping("/board/list")
    public String boardList(Model model) {

       model.addAttribute("list", boardService.boardList());


       return "boardlist";
    }

    @GetMapping("/board/view") // localhost:8080/board/view?id=1
    public String boardView(Model model, Integer id) {

        model.addAttribute("board", boardService.boardView(id));
       return "boardview";
    }


    @GetMapping("/board/delete")
    public String boardDelete(Integer id) {

       boardService.boardDelete(id);

       return "redirect:/board/list";
    }

}

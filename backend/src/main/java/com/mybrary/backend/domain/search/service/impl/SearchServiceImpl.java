package com.mybrary.backend.domain.search.service.impl;

import com.mybrary.backend.domain.book.dto.responseDto.BookGetDto;
import com.mybrary.backend.domain.book.repository.BookRepository;
import com.mybrary.backend.domain.contents.thread.dto.responseDto.ThreadSearchGetDto;
import com.mybrary.backend.domain.member.entity.Member;
import com.mybrary.backend.domain.member.repository.MemberRepository;
import com.mybrary.backend.domain.member.service.MemberService;
import com.mybrary.backend.domain.search.service.SearchService;
import com.mybrary.backend.global.exception.book.BookNotFoundException;
import com.mybrary.backend.global.exception.member.MemberNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SearchServiceImpl implements SearchService {

    private final ElasticsearchTemplate elasticsearchTemplate;
    private final ElasticsearchOperations elasticsearchOperations;
    private final MemberRepository memberRepository;
    private final BookRepository bookRepository;

    @Override
    public List<String> listSuggestedTerms(String keyword) {
        return null;
    }

    @Override
    public List<ThreadSearchGetDto> searchThread(String keyword, Pageable page) {

        // 1. keyword가 포함되어있는 태그 리스트 조회 (페이퍼Id가 중복되면 하나만 가져오기)
//        List<>
        // 2. 태그가 포함된 페이퍼가 포함되어있는 스레드 리스트 조회 (스레드Id가 중복되면 하나만 가져오기)
        //    근데 이때 (좋아요수+스크랩수*5)가 제일 큰 페이퍼Id를 갖고 있어야함

        // 3. (좋아요수+스크랩수*5) 순으로 정렬해서 페이징

        return null;
    }

    @Override
    public List<BookGetDto> searchBook(String email, String keyword, Pageable page) {

        Member me = memberRepository.searchByEmail(email).orElseThrow(MemberNotFoundException::new);

        List<BookGetDto> bookList = bookRepository.searchBookByKeyword(me.getId(), keyword, page).orElseThrow(
            BookNotFoundException::new);

        return bookList;
    }
}

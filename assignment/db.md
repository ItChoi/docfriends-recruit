# DB 설계

1. 회원 정보
   - id (long) pk
   - eamil (varchar) 
   - password (varchar)
   - name (varchar)
   - created_date (date)
   - updated_date (date)
   
2. 문의 정보
   - id (long) pk
   - member_id (long) fk
   - title (varchar)
   - content (text)
   - answer_status (varchar)
   - created_date (date)
   - updated_date (date)
    
3. 문의 답변 정보
   - id (long) pk
   - question_id (long) fk
   - member_id (long)
   - content (text)
   - created_date (date)
   - updated_date (date)
   
4. 해시 태그
   - id (long) pk
   - question_id (long) fk
   - tag_name (varchar) 

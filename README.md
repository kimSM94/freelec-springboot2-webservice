# freelec-springboot2-webservice

1. 템플릿 엔진 - 지정된 템플릿 야익과 데이터가 합쳐져 HTML 문서를 출력하는 소프트웨어
2. 머스테치 - 수많은 언어를 지원하는 가장 심플한 템플릿 엔진
     - JSP,Velocity : 스프링 부트에서는 권장하지 않는 템플릿
     - Freemarker : 템플릿 엔진으로 너무 과하게 많은 기능을 지원. 높은 자유도로 인해 숙련도가 낮을수록 Freemarker 안에 비즈니스 로직이 추가될 확률이 높습니다.
     - Thymeleaf : 스프링 진영에서 적극적으로 밀고 있찌만 문법이 어려움...
  - 머스테치 장점
    1) 문법이 다른 템플릿 엔진보다 심플
    2) 로직 코드를 사용하 수 없어 View의 역할과 서버의 역할이 명확하게 분리
    3) Mustache.js와 Mustache.java 2가지가 다 있어 하나의 문법으로 클라이언트/서버 템플릿을 모두 사용 간ㅇ..

3.  {{#posts}}
   - posts 라는 List를 순회
   - Java의 for문
4. {{id}} 등의 {{변수명}} - 객체의 필드명

5. @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
- SpringDataJpa에서 제공하는 기본 메소드만으로 해결 할 수 있으나 @Query가 훨씬 가독성이 좋으니 선택해ㅓㅅ 사용..

* Querydsl을 추천하는 이유
  1. 타입 안정성이 보장
     -오타나 존재하지 않는 컬럼명을 명시할 경우 IDE에서 자동으로 검출
  2. 국내 많은 회사에서 사용 중입니다.
  3. 레퍼런스가 많음

6.  Model
   - 서버 템플릿 엔진에서 사용할 수 있는 객체를 저장할 수 있다.
   - postsService.findAllDesc를 posts로 index.mustache에 전달

     @GetMapping("/")
    public String index(Model model){
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";

    }

### Spring Sercurity Oauth2 Client 라이브러리 사용해서 진행 및 이유
1. 더는 신규 기능은 추가하지 않고 버그 수정 정도의 기능만 추가될 예정, 신규 기능은 새 oauth2 라이브러리에서만 지원하겠다고 선언
2. 스프링 부트용 라이브러리 출시
3. 기존에 사용되던 방식은 확장 포인트가 적절하게 오픈되어 있지 않아 직접 상속하거나 오버라이딩 해야 하고 신규 라이브러리의 경우 확장포인트를 고려해서 설계된 상태

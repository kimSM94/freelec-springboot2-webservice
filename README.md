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


`

     @GetMapping("/") 
     public String index(Model model){
          model.addAttribute("posts", postsService.findAllDesc());
          return "index";
     }
     
     

### Spring Sercurity Oauth2 Client 라이브러리 사용해서 진행 및 이유
1. 더는 신규 기능은 추가하지 않고 버그 수정 정도의 기능만 추가될 예정, 신규 기능은 새 oauth2 라이브러리에서만 지원하겠다고 선언
2. 스프링 부트용 라이브러리 출시
3. 기존에 사용되던 방식은 확장 포인트가 적절하게 오픈되어 있지 않아 직접 상속하거나 오버라이딩 해야 하고 신규 라이브러리의 경우 확장포인트를 고려해서 설계된 상태

#### Optional
- Optional은 값이 존재할 수도 있고 존재하지 않을 수도 있는 컨테이너 클래스입니다. Optional을 사용함으로써 메서드의 반환 값이 널(null)이 될 가능성을 줄이고, 코드에서 명시적으로 값이 없을 때 어떻게 처리할지를 표현할 수 있습니다.

- 여기서 Optional<User>는 다음과 같은 의미를 가집니다:  EX) Optional<User> findByEmail(String email);

만약 이메일에 해당하는 사용자를 찾았을 경우, Optional에 사용자 객체(User)를 담아서 반환합니다.
이메일에 해당하는 사용자가 없을 경우, Optional은 비어있는 상태로 반환됩니다. 이것은 널(null)을 반환하는 것보다 안전하며, 코드에서 명시적으로 이 상황을 처리할 수 있도록 합니다.

### 스프링 시큐리티 설정
1. spring-boot-starter-oauth2-client : 소셜 로그인 등 클라이언트 입장에서 소셜 기능 구현 시 필요한 의존


 ######  {{#userName}}
- 머스테치는 다른 언어와 같은 if문 제공하지 않으며 true/false만 판단
- 그래서 항상 최종값을 넘겨줘야함

 ######  {{^userName}}
- 머스테치에 해당 값이 존재하지 않는 경우 &를 사용


### 어노테이션 정리
1. @Target(ElementType.PARAMETER) // 이 어노테이션이 생성될 수 있는 위치를 지정. Parameter로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용 가능
2. interface : 어노테이션 클래스로 지정(LoginUser라는 이름을 가진 어노테이션이 생성
3. @WithMockUser(roles = "USER") // 인증된 모의 사용자를 만들어 roles에 권한을 추가



### AWS

##### 클라우드
1. IaaS
   - 기존 물리 장비를 미들웨어와 함께 묶어둔 추상화 서비스
   - 가상머신, 스토리지, 네트워크, 운영체제 등의 IT 인프라를 대여해 주는 서비스
   - AWS의 EC2, S3 등
2. PaaS
   - IaaS를 한 번 더 추상화되어 많은 기능이 자동화
   - AWS의 Beanstalk,Heroku 등
3. SaaS
   - 소프트웨어 서비스
   - 구글 드라이브, 드랍박스, 와탭 등

##### AWS를 선택 하는 이유
1. 1년간 무료
2. 클라우드에서는 기본적으로 지원하는 기능(모니터링, 로그관리, 백업, 복구, 클러스터링 등등)이 ㅁ낳아 개인이나 소규모일 때 개발에 좀더 집중
3. 많은 회사가 AWS로 사용
4. 사용자가 많아 국내 자료와 커뮤니티가 활성화되어 있음.

   - 이 책에서는 IaaS를 사
   

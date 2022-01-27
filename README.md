

#  LattePanda

###  🦝🍰 파스칼 표기법으로 점찍고 돌아온 라떼너구리 <br/>

- `.gitignore` 처리로 IDE 및 OS 환경설정은 제하였습니다.
- `README` 수정은 `master`에서 바로 처리하겠습니다. 내용은 프로젝트가 끝난 후 정리할 예정입니다.
<br/>
- ⭐개인 작업하실 때 꼭 `issue` 등록 후 진행하시기 바랍니다!<br/> 
	-	(프로젝트 진행 상황 파악에 용이합니다, 버그 발견시에도 등록해주세용) <br/>
- ⭐ 정석적인 루트는 issue 등록 > PR > issue closed 순서이긴 합니다ㅎㅎ


<br/>
<br/>

##  Directory (ver. 2022-01-22)
```
└─src
    └─main
        ├─java
        │  └─com
        │      └─test
        │          └─main
        │              ├─customer
        │              │  ├─complain
        │              │  └─survey
        │              ├─home
        │              ├─hr
        │              │  ├─employee
        │              │  ├─schedule
        │              │  └─staff
        │              ├─notice
        │              ├─order
        │              ├─stock
        │              ├─store
        │              └─util
        └─webapp
            ├─asset
            │  ├─css
            │  │  ├─images
            │  │  └─lib
            │  ├─fonts
            │  └─js
            │      └─lib
            └─WEB-INF
                ├─inc
                ├─lib
                │  └─ojdbc10-full
                └─views
                    ├─customer
                    │  ├─complain
                    │  └─survey
                    ├─home
                    ├─hr
                    │  ├─employee
                    │  ├─schedule
                    │  └─staff
                    ├─notice
                    ├─order
                    ├─stock
                    └─store
```
<br/>
<br/>


## Commit convention 
### Branch 명명규칙
```
Jo_JU
Choe_SH
Kang_KJ
Lee_JH
Im_HH
```
- 각자 이름으로 Branch 따서 작업하겠습니다.
- `파스칼 + 스네이크` 표기법으로 하며 성은 풀로, 이름은 이니셜을 따서 만듭니다.
- **모든 개인 작업은 브랜치**에서 작업 후 `Pull Request` 요청으로 `master`에 merge 합니다.
<br/>
<br/>


### Commit 명명규칙
- 효율적인 협업을 위해 컨벤션을 지켜 commit 해주세요!
- 꼼꼼하게 할수록 본인 파트의 코드 관리뿐만 아니라 타인이 작업한 결과물 파악에도 쉽습니다.
- 하단에 예시를 적어놨습니다. 내용은 한글, 영어 상관없으나 `타입`, `동사` 등의 규칙은 지켜주시기 바랍니다.
- `범위(scope)` 내용은 필수는 아니니 본인 작업 및 재량껏 하시기 바랍니다.
<br/>

```
[타입](범위): [동사] 내용
```
- 제목의 처음은 동사 원형으로 시작.
- 마지막에 특수문자는 삽입하지 않습니다. 
	- 예) 마침표(.), 느낌표(!), 물음표(?)
<br/>

#### 타입 종류
- Feat: 새로운 기능을 추가할 경우
- Fix: 코드 수정, 버그를 고친 경우
- Refactor: 프로덕션 코드 리팩토링, 새로운 기능이나 버그 수정없이 현재 구현을 개선한 경우
- Design: CSS 등 사용자 UI 디자인 변경
- Style: 코드 포맷 변경, 세미 콜론 누락, 코드 수정이 없는 경우
- Comment: 필요한 주석 추가 및 변경
- Docs: 문서를 수정한 경우
- Test: 테스트 추가, 테스트 리팩토링 (프로덕션 코드 변경 없음)
- Chore 빌드 태스트 업데이트, 패키지 매니저를 설정하는 경우(프로덕션 코드 변경 X)
- Rename: 파일 혹은 폴더명을 수정하는 경우
- Remove: 사용하지 않는 파일 혹은 폴더를 삭제하는 경우

<br/>
<br/>

#### 동사 종류
 - Add : 추가
 - Edit : 코드 수정
 - Remove : 삭제
 - Update : 문서, 버전 등의 업데이트 (코드 수정에서 사용 X)
<br/>
- 대문자 시작
- **필요 동사 셀프 추가 사용**


<br/>
<br/>

#### 예시
```
[Feat](메뉴관리): Add 메뉴관리 기능 추가
[Fix](메뉴조회): Remove 라인 삭제
[Fix](메뉴추가): Edit 타이틀 수정
[Remove](메뉴공개등급): Remove addok.jsp 파일 삭제
[Comment](매출관리): Add 주석 추가
[Design](메뉴관리): Edit 메뉴조회 CSS 수정
[Desgin](메뉴관리): Remove 메뉴조회 테이블 삭제

[Docs](Readme): Update README.md 업데이트

[Chore](공통): Add 라이브러리 추가
[Chore](공통): Edit 클래스패스 재설정
[Refactor](공통): Change 패키지 폴더 구조 재구성
```
<br/>
<br/>

#### 참고
[커밋 컨벤션 참고 자료](https://overcome-the-limits.tistory.com/entry/%ED%98%91%EC%97%85-%ED%98%91%EC%97%85%EC%9D%84-%EC%9C%84%ED%95%9C-%EA%B8%B0%EB%B3%B8%EC%A0%81%EC%9D%B8-git-%EC%BB%A4%EB%B0%8B%EC%BB%A8%EB%B2%A4%EC%85%98-%EC%84%A4%EC%A0%95%ED%95%98%EA%B8%B0)
<br/>
<br/>



## DBUtil 설정법
1. 본인 월렛 폴더에 `login.txt`를 새로 만듭니다.
2. 해당 txt 파일에 월렛 `id`, `pw`를 넣고 저장합니다.
	- `,` 구분이며 공백은 넣으면 안됩니다.
```
id,password
```
3. `DBUtil.java` 클래스의 `url`을 본인 월렛 폴더 경로로 수정합니다.

```
public static Connection open() {

        Connection conn = null;
        String url = "jdbc:oracle:thin:@db202201141741_medium?TNS_ADMIN=본인월렛폴더경로";
        String path = url.split("TNS_ADMIN=")[1] + "/login.txt";
```

4. `Main.java`를 실행하여 연결 결과를 확인합니다.<br/>
![image](https://user-images.githubusercontent.com/42857790/150262743-657a7f69-1e31-4c47-ae1c-e0a3502637c7.png)

<br/>
<br/>

## Library
- ojdbc10
- jstl
- BootStrap
- jQuery
- jQuery-UI
- HiChart

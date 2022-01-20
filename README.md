
#  LattePanda

###  🦝🍰 파스칼 표기법으로 점찍고 돌아온 라떼너구리 <br/>

- `.gitignore` 처리로 IDE 및 OS 환경설정은 제하였습니다.

<br/>

##  Directory (ver. 2022-01-20)
```
└─src
    └─main
        ├─java
        │  └─com
        │      └─test
        │          └─main
        │              └─util
        └─webapp
            ├─asset
            │  ├─css
            │  │  └─images
            │  ├─fonts
            │  └─js
            ├─inc
            └─WEB-INF
                └─lib
                    └─ojdbc10-full
```
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

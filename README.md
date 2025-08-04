## 📬 익명 롤링 페이퍼 웹 사이트 - 두근두근 우체통

#### ✔️ 개요

```
Spring Boot 중심으로 백엔드 개발 역량을 키우기 위해 개인적으로 진행한 '익명 롤링 페이퍼' 프로젝트 '두근두근 우체통'입니다.
유저에게 익명으로 편지를 전송할 수 있으며, 익명 편지를 받은 유저는 편지를 확인할 수 있지만 누가 전송했는지는 절대 알 수 없습니다.

REST API, DB 연동을 모두 설계하고 구현할 수 있으려면 어떤 주제가 좋을까 생각하다가 평소 주변인들에게 편지 쓰는 것을 좋아하며
친구들끼리 소소한 재미를 추구하고 싶을 때 이용해 보면 좋을 것 같다는 생각에 이 주제를 고르게 되었습니다. 😉
```

#### ✔️ 사용 기술
```
HTML, CSS, JavaScript, Java, Spring Boot, PostgreSQL, Figma
```

#### ✔️ 설명

**0. 메인**
```
- 웹에 접속하면 가장 먼저 화면에 뜨는 메인 화면입니다.
- 내 페이지 만들기 -> 회원 가입 페이지로 넘어갑니다.
- 내 페이지 확인하기 -> 로그인 페이지로 넘어갑니다.
```

<img width="723" height="387" alt="image" src="https://github.com/user-attachments/assets/f8072df8-6bd4-4654-bd89-819a2f93598e" /> <br>


**1. 회원 가입**
```
- 아이디, 이름, 비밀번호를 입력받습니다.
- 다른 유저가 사용 중인 아이디로 가입되지 않도록 아이디 중복 확인을 할 수 있습니다.
- 비밀번호와 비밀번호 확인 칸의 입력 값이 같지 않다면 회원가입이 진행되지 않습니다.
```
<img width="722" height="387" alt="image" src="https://github.com/user-attachments/assets/cbc458de-e3d5-4a21-a0d9-b93d73d1c7cb" /> <br>

**2. 로그인**
```
- 회원 가입 시 입력했던 아이디, 비밀번호로 로그인 가능합니다.
- 수신된 익명 편지를 확인하기 위해 필요한 절차입니다.
```
<img width="725" height="381" alt="image" src="https://github.com/user-attachments/assets/d4045268-88be-474c-9d33-221f06eed1c1" /> <br>

**3. 메시지 작성**
```
- 익명 편지를 작성하고, 편지에 함께 표시될 대표 이모지를 설정할 수 있습니다.
- 화면에 있는 이모지를 클릭하면 이모지를 선택할 수 있는 창이 나오고, 선택을 완료하면 창이 닫힙니다.
```

<img width="726" height="386" alt="image" src="https://github.com/user-attachments/assets/e6d65d74-add6-4264-94f3-02e514e23dec" /> <br>

**4. 메시지 확인**
```
- 마이 페이지에서 유저에게 수신된 메시지의 수만큼 화면에 포스트잇 아이콘이 표시됩니다.
- 특정 포스트잇을 누르면 특정 메시지와 대표 이미지가 모달 형식으로 나타납니다. 
```
<img width="723" height="617" alt="image" src="https://github.com/user-attachments/assets/544961e3-1f5d-44a7-a561-886cbbf88039" /> <br>

**5. 비인가 유저 화면**
```
- 특정 유저의 마이 페이지를 접근하려 할 때 로그인 된 세션(혹은 로그인하지 않은 상태의 세션)과 페이지의 주인이 일치하지 않을 때 표시되는 화면입니다.
- 화면에 있는 아이콘을 클릭하면 3. 메시지 작성에서 설명한 페이지로 넘어갑니다.
```

<img width="731" height="383" alt="image" src="https://github.com/user-attachments/assets/8f7ef671-7dd4-4c0b-80f1-e6279664f793" /> <br>


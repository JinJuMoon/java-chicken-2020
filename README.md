# java- [ ]chicken- [ ]2020
- [ ] 치킨집 사장님이 사용하는 간단한 포스(POS) 프로그램을 구현한다.

## 구현할 기능 목록

0. 메인화면
- [ ] 선택 가능한 기능들을 보여주는 기능
- [ ] 원하는 기능을 선택하는 기능
- [ ] 해당 기능을 수행한 후 다시 메인화면으로 돌아오는 기능


1. 주문 등록 기능
- [ ] 테이블 목록을 보여주는 기능
    - [ ] 주문 등록된 테이블을 결제가 이루어지기 전까지 테이블 목록에 별도로 표시하는 기능
    
- [ ] 주문을 등록할 테이블 번호를 입력하는 기능
    - [ ] 테이블은 테이블 번호를 가진다.

- [ ] 등록할 메뉴를 보여주는 기능
    - [ ] 메뉴는 메뉴번호, 종류, 이름, 가격을 가진다.
- [ ] 등록할 메뉴의 번호를 입력하는 기능

- [ ] 등록할 메뉴의 수량을 입력하는 기능
    - [ ] 한 테이블에서 주문할 수 있는 한 메뉴의 최대수량은 99개이다.


2. 결제하기 기능
- [ ] 선택된 테이블의 주문 내역을 보여주는 기능
- [ ] 결제수단의 번호를 입력하는 기능
- [ ] 최종 결제할 금액을 계산하는 기능
    - [ ] 치킨 종류 메뉴의 수량 합이 10개가 넘는 경우 10,000원씩 할인된다.
        ex) e.g.10개는10,000원할인,20개는20,000원할인
    - [ ] 현금 결제할 경우 전체 금액의 5%를 할인한다. 할인된 금액에서 한번 더 할인이 가능하다.
- [ ] 최종 결제할 금액을 보여주는 기능

3. 프로그램 종료 기능
- [ ] 프로그램을 종료하는 기능
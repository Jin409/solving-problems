# [BRONZE I] 평균은 넘겠지 - 4344

- [문제 링크](https://www.acmicpc.net/problem/4344)

## 성능 요약

메모리: 16164 KB, 시간: 188 ms

## 분류

- 수학
- 사칙연산

## 풀이 방식

- 스트림을 이용해서 평균을 구하므로 average 가 null 일수도 있기에 OptionalDouble 로 결과를 받는다.
- 소수점 셋째까지 출력해야 하므로 .3f 를 이용한다.

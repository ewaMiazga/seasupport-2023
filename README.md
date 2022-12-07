# SeaSupPort



## Cel projektu

Celem projektu jest stworzenie aplikacji desktopowej obsługującej polskie porty morskie. Aplikacja będzie umożliwiała użytkownikowi sprawdzenie listy portów, rezerwacji wolnego miejsca i dodawanie swojego jachtu. A administratorzy portów będą mieli możliwość m.in. zarządzania rezerwacjami.


## Podstawowe założenia aplikacji

- Aplikacja będzie wymagała zalogowania się przez użytkownika.
- Użytkownicy będą podzieleni na administratorów portów i zwykłych użytkowników (żeglarzy).
- Będzie możliwość dodania swojego jachtu i podania jego szczegółowych informacji.
- W aplikacji będzie lista działających polskich portów morski.
- Aplikacja będzie posiadała szczegółowe informacje o portach, a także umożliwi sprawdzenie i rezerwacje miejsca w porcie.


## Priorytety projektu

- Stworzenie intuicyjnego oraz przyjaznego dla użytkownika interfejsu graficznego.
- Baza danych zgodna ze standardami modelu relacyjnego. 
- Budowa aplikacji przystosowana do późniejszego rozwoju i dodania kolejnych modułów.


## Instalacja i uruchomienie aplikacji

Do zainstalowania aplikacji potrzebny będzie Maven zainstalowany na własnym komputerze.
Pobierabmy wszystkie pliki z repozytorium.

Kompilujemy kod i zasoby za pomocą komend
```
mvn compiler:compile
mvn resources:resources
```
Uruchamiamy aplikację
```
mvn javafx:run
```


## Skład zespołu

Ewa Miazga, Bartłomiej Niewiarowski, Michał Jakomulski, Mikołaj Taudul


## Wstępna deklaracja wybranej technologii

- Interfejs graficzny: JavaFX.
- Narzędzie do kontroli wersji: git
- Baza danych: Oracle Database
- Narzędzie do budowania aplikacji: Maven
- Testy jednostkowe: JUnit
- Łączenie się z bazą danych z poziomu aplikacji: do uzgodnienia
- Dokumentacja: JavaDoc


## Model relacyjny bazy danych

![model_relacyjny.png](./db_scripts/model_relacyjny.png)

## Model logiczny bazy danych

![mode_logiczny.png](./db_scripts/mode_logiczny.png)


## Workflow

```
seasupport
   ├ App
     └ src
         ├ app
         └ logic
   ├ db_scripts
   └ doc
```

## Gitflow
Repozytorium powinno być budowane według systemu zarządzania gałęziami gitflow:

```
main
  ├ feature-styling-dialogs
  ├ feature-branch-logic
  ...
  └ feature-database-connection
```

Praca na repozytorium:
1. Stwórz nową gałąź:
```
git checkout -b feature-new-branch
```
2. Praca nad nową funkcjonalnością:
1. Dodaj zmienione pliki do repozytorium:
```
git add <files>
```
2. Zapisz poczynione zmiany:
```
git commit -m  "message"
```
3. Zaaktualizuj ścieżkę commitów:
```
git rebase origin main
```
4. Wyślij zmiany:
```
git push
```
5. Zmień branch na main:
```
git checkout main
```
6. Pobierz nowe zmiany:
```
git pull
```
7. Otwórz merge request w gitlabie


## Frequently Asked Questions

## Spis Treści

<!-- AUTOGENERATED TOC -->

1.	[Frequently Asked Questions](#frequently-asked-questions)
	1.	[Spis Treści](#Spis-treści)
	2.	[Pytania ogólne](#Pytania-ogólne)
		1.	[Jak sktuczenie uruchomić aplikację?](#Jak-skutecznie-uruchomić-aplikację?)


# Avaliando a acessibilidade de aplicação móveis: a plataforma de desenvolvimento da língua de execucão importam? // Assessing the accessibility of mobile applications: does the platform development and execution language matter?

This repo contains the data for our research entitled *["Avaliando a acessibilidade de aplicação móveis: a plataforma de desenvolvimento da língua de execucão importam?"](https://)* by [Matheus Gomes](https://), [Daniel Mesquista](https://), [Isaac Santos](https://), [Paulo Henrique](https://), [Ribamar Souza](https://) and [Windson Viana](https://).

## Introduction
The objective of this research is to explore and analyze the current state of cross-platform app accessibility across multiple categories, including education and lifestyle apps. Furthermore, another goal is to evaluate them in different languages, such as Portuguese and English.

### Study Objects
To select the first applications to be evaluated, we chose to use an application repository called [Androzoo](https://androzoo.uni.lu). AndroZoo is a growing collection of Android Applications collected from several sources, including the official Google Play app market.

In the end, 198 apps were selected for testing and all of those chosen were multiplatform, with only Ionic, React Native and Flutter. In addition, entries from different categories were selected.

### Materials and Methods
The tool used for testing was [Firebase Test Lab](https://firebase.google.com/docs/test-lab) which is a mobile application testing platform developed by Google as part of the Firebase toolset. It allows developers to run automated tests on their Android and iOS apps on a wide range of real and virtual devices hosted on Google's infrastructure.

The image bellow.. (colocar uma imagem do erros que firebase encontrou, tem algum print?)

### Procedure
The applications were divided between five people, and everyone configured the same information in Firebase to ensure test consistency. For both languages, we configured Firebase Test Lab to run the mobile apps for five minutes using the same virtual device, Pixel 5.

Some parameters were established during the error count, to define which applications would have their tests disregarded, the parameters included whether the application had gotten stuck on the login screen, whether it made fatal errors that prevented the test from being executed, or whether it did not go through. more than 5 screens. Therefore, the results of 72 applications were disregarded because they did not meet established requirements. Furthermore, tests in Portuguese were also disregarded, as only 36 applications supported the language.

### Results
The results were separated into two datasets, given the large number of apps that were disregarded. The [raw_dataset](https://github.com/Test-Accessibility/Dataset-avaliacoes-acessibilidade/blob/main/Estudo%2001/massive_apps_raw_dataset.csv) contains all the results found, including the disregarded tests. The [dataset](https://github.com/Test-Accessibility/Dataset-avaliacoes-acessibilidade/blob/main/Estudo%2001/massive_apps_dataset.csv) only contains the results of the tests that were considered for this research. Both datasets are present in this repo.

As a result of this research, 126 mobile applications were evaluated only in English with **2713** total accessibility errors, with an average of **0.5** errors per screen. The table below shows more information about the tests.

|                                            | **React Native** | **Ionic** | **Flutter** | **Total** |
|--------------------------------------------|------------------|-----------|-------------|-----------|
| **# Apps**                                 | 86               | 37        | 3           | 126       |
| **# Screens Evaluated**                    | 4118             | 1186      | 172         | 5476      |
| **# Errors Found**                         | 2558             | 50        | 105         | 2713      |
| **Mean Errors per App**                    | 29,74            | 8,40      | 35          | 21,53     |
| **Standard Deviation of Errors per App**   | 25,69            | 2,06      | 58,89       | -         |
| **Mean Errors per Screen**                 | 0,67             | 0,04      | 1,50        | 0,50      |
| **Standard Deviation of Errors by Screen** | 0,52             | 0,06      | 2,58        | -         |

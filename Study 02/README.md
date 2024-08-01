# Investigating the accessibility of popular mobile Android apps: a prevalence, category, and language study

This repo contains the data for our WebMedia 2024 accessibility research paper entitled *["Investigating the accessibility of popular mobile Android apps: a prevalence, category, and language study"](https://)* by [Matheus Gomes](https://), [Daniel Mesquista](https://), [Ribamar Souza](https://) and [Windson Viana](https://). Note: we have a follow-up paper focused primarily on large-scale bibliometric analysis. You can find the repo for that other work [here](https://).

## Introduction
The objective of this research is to analyze the current level of accessibility of popular applications in the Android ecosystem across various categories, including apps dealing with music and videos. Furthermore, another goal is to evaluate them in different languages, such as Portuguese, English, and Spanish.

### Study Objects
To select the first ten apps to be evaluated, we chose to use a list of apps from another research project unrelated to our own. This allowed us to start by analyzing popular apps without a selection bias from our research group. Additionally, the apps belong to five distinct categories. Table shows the apps evaluated during the study, their category, and their number of downloads on the Play Store, which range from 50 million to 10 billion.

|    **Application**   |   **Category**  | **Downloads** |
|:--------------------:|:---------------:|:-------------:|
|         ESPN         |       News      |     50 mi     |
| The Weather Channel  |       News      |     100 mi    |
|       Linkedin       |   Social Media  |      1 bi     |
|       Pinterest      |   Social Media  |      1 bi     |
|      SoundCloud      | Audio Streaming |     100 mi    |
|        Spotify       | Audio Streaming |      1 bi     |
|        Twitch        | Video Streaming |     100 mi    |
|        YouTube       | Video Streaming |     10 bi     |
|        Shopee        |   E-Commerce    |     100 mi    |
|        Copang        |   E-Commerce    |     50 mi     |


### Materials and Methods
We used the [Accessibility Scanner](https://support.google.com/accessibility/android/faq/6376582?hl=pt-BR) tool to evaluate the apps. This Google tool assesses app interfaces during manual navigation and identifies accessibility issues. Designed for developers and designers, it offers improvement suggestions and generates detailed reports, identifying issues with contrast, font sizes, and button labels.

During the app analysis process, two evaluators, each with a different Android device, executed the evaluation protocol. One used a Galaxy S22 Ultra and the other a Galaxy A03.

<div align="left">
<img src="https://github.com/Test-Accessibility/Dataset-avaliacoes-acessibilidade/assets/174071237/017fed25-d8c4-4047-99c1-f1f8b9bf7254" width="700px" />
</div>

### Procedure
We defined a list of activities to be performed according to the app category to ensure navigation consistent with the proper use of the app. The two evaluators changed the smartphones' language settings before executing the activities. The evaluation protocol was then repeated. The same evaluator checked accessibility across different language executions using the Accessibility Scanner. This tool evaluated all interactions through screen captures, enabling the identification of accessibility errors in multiple languages during navigation.

### Results
The results can be found in [dataset](https://github.com/Test-Accessibility/Dataset-avaliacoes-acessibilidade/blob/main/Estudo%2002/10_popular_apps_dataset.csv) in this repo.

We had some issues with two apps. The Coupang app only had the Korean language available, making it impossible to change the language according to the device's region settings. The Shopee app did not allow changing the language to English or Spanish. The Coupang app was exclude from the result analysis, and we only checked the Portuguese version of the Shopee app.

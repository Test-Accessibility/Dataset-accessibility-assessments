# Investigating the accessibility of popular mobile Android apps: a prevalence, category, and language study

This repo contains the data and code for our webmedia 2024 accessibility literature survey paper entitled *["Investigating the accessibility of popular mobile Android apps: a prevalence, category, and language study"](https://)* by [Matheus Gomes](https://), [Daniel Mesquista](https://), [Ribamar Souza](https://). Note: we have a follow-up paper focused primarily on large-scale bibliometric analysis. You can find the repo for that other work [here](https://).

## Introduction (talvez... nao sei se precisa de titulo para essa parte)
Objective of this research is to analyze the current level of accessibility of popular applications in the Android ecosystem across various categories, including apps dealing with music and videos. Furthermore, another goal is to evaluate them in different languages, such as Portuguese, English, and Spanish.

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
We used the Accessibility Scanner tool to evaluate the apps. This Google tool assesses app interfaces during manual navigation and identifies accessibility issues. Designed for developers and designers, it offers improvement suggestions and generates detailed reports, identifying issues with contrast, font sizes, and button labels. The definitions of the identified accessibility errors are available on the tool's [website](https://support.google.com/accessibility/android/faq/6376582?hl=pt-BR). For instance, Figure [figura](colocar_figura_na_web_dps) highlights the accessibility errors detected with the help of the Accessibility Scanner. The tool identified visually the contrast errors and touch area size issues on the SoundCloud app's home screen.

During the app analysis process, two evaluators, each with a different Android device, executed the evaluation protocol. One used a Galaxy S22 Ultra and the other a Galaxy A03. Table \ref{tab:materiais_qp2} identifies the smartphone used for the evaluated apps and their Android versions.

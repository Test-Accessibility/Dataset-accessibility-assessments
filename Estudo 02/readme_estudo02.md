# Investigating the accessibility of popular mobile Android apps: a prevalence, category, and language study

This repo contains the data and code for our webmedia 2024 accessibility literature survey paper entitled *["Investigating the accessibility of popular mobile Android apps: a prevalence, category, and language study"](https://)* by [Matheus Gomes](https://), [Daniel Mesquista](https://), [Ribamar Souza](https://). Note: we have a follow-up paper focused primarily on large-scale bibliometric analysis. You can find the repo for that other work [here](https://).

Please cite this dataset as:

> Kelly Mack, Emma McDonnell, Dhruv Jain, Lucy Lu Wang, Jon E. Froehlich, and Leah Findlater. 2021. What Do We Mean by “Accessibility Research”? A Literature Survey of Accessibility Papers in CHI and ASSETS from 1994 to 2019. Proceedings of the 2021 CHI Conference on Human Factors in Computing Systems. Association for Computing Machinery, New York, NY, USA, Article 371, 1–18. DOI:https://doi.org/10.1145/3411764.3445412



## Analyses and Datasets
The Mack paper presents analyses of two accessibility paper datasets drawn from CHI and ASSETS:

1. **Study 1**: A qualitative analysis of accessibility papers from 2010-2019 (N=506 papers).
2. **Study 2**: A larger programmatic analysis of the last 26-years of accessibility papers—since the founding of ASSETS (N=836 papers)

### Study 1
To analyze the 506 accessibility papers from 2010-2019 at CHI and ASSETS, we used an iterative process to develop and apply a codebook. See Sections 3.1.1 and 3.2.1 and Sections 4.1, 4.2, and 4.3 of the Mack et al. paper.

- **[Dataset1_QualitativeCodebook.docx](/datasets/Dataset1_QualitativeCodebook.docx)**: The codebook includes deductive codes based on our research questions, such as user communities of focus, technologies, and study methods as well as codes that were inductively added as we pursue our analysis. See Section 3.2.1 in the CHI'21 paper for details.

- **[Dataset1_QualitativelyCodedData_ASSETSandCHI_2010-2019.csv](/datasets/Dataset1_QualitativelyCodedData_ASSETSandCHI_2010-2019.csv)**: The results of our qualitative analysis using the above codebook

- **[Dataset1_TotalPaperCountsPerYear_ASSETSandCHI_2010-2019.csv](/datasets/Dataset1_TotalPaperCountsPerYear_ASSETSandCHI_2010-2019.csv)**: The total number of papers at ASSETS and CHI from 2010-2019.

- **[Study1_QualitativeAnalysis.ipynb](/src/Study1_QualitativeAnalysis.ipynb)**: The analysis scripts for Study 1. You can open up this notebook live in your browser using [binder](https://mybinder.org/v2/gh/makeabilitylab/accessibility-literature-survey/HEAD) or run it locally using Jupyter Notebook and Anaconda. See [src/README.md](/src).

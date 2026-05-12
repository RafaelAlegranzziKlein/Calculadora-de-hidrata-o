# HydroGoal - Controle de Hidratação Diária
## Descrição do Projeto
O **HydroGoal** é um aplicativo Android desenvolvido para ajudar usuários a
manterem hábitos saudáveis de hidratação. Com base no peso corporal e nível
de atividade física, o app calcula a meta ideal de ingestão de água e
monitora quanto ainda falta para atingir o objetivo do dia.
---
## Interface do Aplicativo

<img width="271" height="483" alt="image" src="https://github.com/user-attachments/assets/b9c47ab0-b5e5-4444-a7ef-ea63bb6facb5" />

---
## Regras de Negócio
1. **Consumo Base:** 35ml de água para cada kg de peso corporal.
2. **Adicional por Atividade:**
- Sedentário: +0ml
- Moderado: +300ml
- Intenso: +600ml
3. **Cálculo de Progresso:** Subtração da ingestão atual em relação à meta
calculada.
---
## Tecnologias
- **Linguagem:** Java
- **Interface:** XML (Material Design)
- **Ferramenta:** Android Studio
---
## Funcionalidades
- [x] Cálculo personalizado por peso.
- [x] Ajuste por nível de atividade física.
- [x] Contador de ingestão restante.
- [x] Validação de campos numéricos.

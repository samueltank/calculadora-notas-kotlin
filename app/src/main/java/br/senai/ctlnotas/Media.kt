package br.senai.ctlnotas

fun alunoStatus(media: Int): String {
    if (media >= 5)
    {
        return "Aprovado!";
    } else
    {
        return "Reprovado!";
    }
}



fun calcMedia(vararg notas:Int) : Int // vararg cria um parâmetro com vários argumentos
{
    var soma = 0;
    for (nota in notas)
    {
        soma += nota;
    }

    return (soma/notas.size);
}
import scala.collection.mutable

object AnagramsAlg1 {
  def main(args: Array[String]): Unit = {
    var listOfAnagrams:List[mutable.Set[String]] = List[mutable.Set[String]]();
    if(args.isEmpty){
      listOfAnagrams = solve("Angel, dog, God, doggy, glean, gleam, meal");
    }else{
      listOfAnagrams = solve(args);
    }
    println(listOfAnagrams.mkString)
  }

  def solve(s: String) : List[ scala.collection.mutable.Set[String]] = {
    val words: Array[String] = s.split(",").map(_.trim)
    solve(words)
  }

  def solve(words: Array[String]) :  List[ scala.collection.mutable.Set[String]] ={
    val sanitizedWords = words.map(_.replaceAll(",","" ).trim)
    val mapToSet : scala.collection.mutable.Map[String, scala.collection.mutable.Set[String]] = scala.collection.mutable.Map[String, scala.collection.mutable.Set[String]]()
    for( word <- sanitizedWords ){
      val chars = Array.fill(26){0}
      for(c <- word.toLowerCase().toCharArray){
        chars.update(c-'a',chars(c-'a')+1);
      }
      val chWord: String = chars.mkString
      val set :  scala.collection.mutable.Set[String] = mapToSet.getOrElse(chWord, scala.collection.mutable.Set[String]());
      set.add(word)
      mapToSet.update(chWord,set)
    }
    mapToSet.values.toList
  }
}

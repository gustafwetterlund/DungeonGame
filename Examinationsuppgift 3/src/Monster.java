import java.util.Random;

public class Monster {
 Random randMonst = new Random();
 private String[] randomMonster = {"Troll","Zombie","Vampire","Skeleton","Orc","Dark Wizard","Frost Giant","Undead Knight"};
 private String rndMonster = randomMonster[randMonst.nextInt(randomMonster.length)];
 private String monsterNamn;
 private int monsterSkada;
 private int monsterHp;
 
 public Monster(String monsterName,int monsterDamage,int monsterHealth){
 this.monsterNamn = monsterName;
 this.monsterSkada = monsterDamage;
 this.monsterHp = monsterHealth;
         
 }
    
public int getMonsterHp(){
return this.monsterHp;
}
public void setMonsterHp(int monsterHp){
this.monsterHp = monsterHp;
}

public String getMonsterName(){
return this.monsterNamn;
}
public void setMonsterName(String monsterNamnTest){
 this.monsterNamn = monsterNamnTest;
}
public void monsterTakingDamage(){
this.monsterHp -= Player.getDamage();

}
public void monsterTakeSwordDmg(){
this.monsterHp -= 20;
}


public int getMonsterDamage(){
return this.monsterSkada;
}

public void setMonsterDamage(int monsterSkada){
 this.monsterSkada = monsterSkada;
}

public String monsterRandomizer(){
this.monsterNamn = rndMonster;
return this.monsterNamn;
}
}
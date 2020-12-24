package problem;

import java.util.ArrayList;
import java.util.List;

class Member {
  private String name;
  // 逗号分隔的 Member.name
  // 注意初始化值
  private String excludes = "";

  private Boolean hasScheduled = false;

  public Member(){}

  public Member(String name) {
    this.name = name;
  }

  public Member(String name, String excludes) {
    this.name = name;
    this.excludes = excludes;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getExcludes() {
    return excludes;
  }

  public void setExcludes(String excludes) {
    this.excludes = excludes;
  }

  public Boolean getHasScheduled() {
    return hasScheduled;
  }

  public void setHasScheduled(Boolean hasScheduled) {
    this.hasScheduled = hasScheduled;
  }
}

class Team {
  private String name;
  private List<Member> members = new ArrayList<>();

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addMember(Member member) {
    this.members.add(member);
  }

  public List<Member> getMembers() {
    return members;
  }

  public void setMembers(List<Member> members) {
    this.members = members;
  }

  public String compete(Team team) {
    StringBuilder builder = new StringBuilder();
    // A / B 依次遍历，剔除 excludes，选择 hasScheduled = false 的匹配；再设置相应的 scheduled
    // cons: 只能输出一种匹配方式
    char dash = '-';

    for (Member teammate : this.getMembers()) {
      for (Member opponent : team.getMembers()) {
        if (opponent.getHasScheduled() ||
          teammate.getExcludes().contains(opponent.getName()) ||
          opponent.getExcludes().contains(teammate.getName())) {
          continue;
        }

        builder.append(this.getName());
        builder.append(dash);
        builder.append(teammate.getName());
        builder.append(" VS ");
        builder.append(team.getName());
        builder.append(dash);
        builder.append(opponent.getName());
        builder.append('\n');

        teammate.setHasScheduled(true);
        opponent.setHasScheduled(true);
        break;
      }
    }

    return builder.toString();
  }
}

public class BadmintonCompetition {
  public static void main(String[] args) {
    Team team1 = new Team();
    team1.setName("甲");
    team1.addMember(new Member("A", "X"));
    team1.addMember(new Member("B"));
    team1.addMember(new Member("C", "X,Y"));

    Team team2 = new Team();
    team2.setName("乙");
    team2.addMember(new Member("X"));
    team2.addMember(new Member("Y"));
    team2.addMember(new Member("Z"));

    System.out.println(team1.compete(team2));
  }
}

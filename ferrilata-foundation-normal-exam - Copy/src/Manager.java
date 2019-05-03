public class Manager extends Employee {
  private int moodLevel = 400;

  public int getMoodLevel() {
    return moodLevel;
  }

  public void setMoodLevel(int moodLevel) {
    this.moodLevel = moodLevel;
  }

  @Override
  public void work() {
    this.setExperience(this.getExperience() + 1);
    this.haveAMeeting();
  }

  public void haveAMeeting () {
    this.setMoodLevel(this.getMoodLevel() - this.getExperience());
  }
}

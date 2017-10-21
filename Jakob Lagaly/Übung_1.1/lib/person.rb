class Person
  attr_accessor :name, :hobbies

  def name
    @name
  end

  def name=(value)
    @name = value
  end

  def hobbies
    @hobbies
  end

  def hobbies=(value)
    @hobbies = value.split(",")
  end

  def initialize(attributes = {})
    attributes.each {|key, value| send "#{key}=", value}
  end

  def commonHobbies(p2)
    @hobbies & p2.hobbies
  end

  def self.friendslist(persons)
    result = []
    work_array = persons
    i=0
    for p1 in persons
      for p2 in work_array-[p1]
        if !p1.commonHobbies(p2).empty?
          result[i] = [p1.commonHobbies(p2).length] + [p1.commonHobbies(p2).join(", ")] + [p1.name, p2.name]
          i+=1
          work_array = work_array-[p1]
        end
      end
    end
    return result
  end
end

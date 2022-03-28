local current = redis.call('GET', KEYS[1])
if current == ARGV[1]
  then redis.call('SET', KEYS[1], ARGV[2]) --如果key的值是传入的argv1,则把这个key的值设置为argv2
  return true
end
return false
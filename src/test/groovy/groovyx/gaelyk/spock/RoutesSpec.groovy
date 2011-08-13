package groovyx.gaelyk.spock

class RoutesSpec extends GaelykRoutingSpec {
	
	def setup(){
		routing 'routes.groovy'
	}
	
	def "the routing fixtures are in place"(){
		expect:
		routes
	}
	
	def "the routing fixtures may be run"(){
		expect:
		routes.run()
	}
	
	def "a redirect of a mapping may be configured"(){
		when:
		routes.run()
		
		then:
		mapped '/about'
		redirect '/about' to "/blog/2008/10/20/welcome-to-my-blog"
	}
	
	def "a forward of a mapping may be configured"(){
		when:
		routes.run()
		
		then:
		mapped '/other'
		forward '/other' to "/blog/2008/10/20/welcome-to-my-other-blog"
	}
	
}
